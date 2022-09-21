#include <ctype.h>
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "linkedlistutils.h"
#include "doublylinkedlistutils.h"

#define NUMBER_OF_LISTS 5 
#define BUFFER_SIZE 5000

void print_available_storage(node_t* p_array[], int selected_list_index) 
{
	printf("\nAvailable storages.\n");
	for (int i = 0; i < NUMBER_OF_LISTS; i++)
	{
		if (i == selected_list_index)
			printf("* %d. ", i);
		else
			printf("  %d. ", i);
		if (p_array[i] != NULL)
			print_list(p_array[i]);
		else
			printf(" NULL\n");
	}	
}

void select_new_storage(node_t* p_array[], int* selected_list_index)
{
	printf("Pick a new storage.\n");
	printf("Storage: ");
	scanf("%d", selected_list_index);
	for (int i = 0; i < NUMBER_OF_LISTS; i++)
	{
		if (i == *selected_list_index)
			printf("* %d. ", i);
		else
			printf("  %d. ", i);
		if (p_array[i] != NULL)
			print_list(p_array[i]);
		else
			printf(" NULL\n");
	}
}

int main() {
	node_t* p_array[NUMBER_OF_LISTS] = {NULL};
	node_t* current_node = NULL;
	int selected_list_index = 0;
	int value = 0;
	int index = 0;
	int searched_value = 0;

	char* welcome_message = "Hello, user. Please choose an option:\n"
					  "\t[s] Select storage for the list.\n"
					  "\t[q] Show available storage.\n"
					  "\t[p] Print the list.\n"
					  "\t[1] Append to the list.\n"
					  "\t[2] Prepend to the list.\n"
					  "\t[3] Reverse the list.\n"
					  "\t[4] Add a value at index.\n"
					  "\t[5] Remove a value at index.\n"
					  "\t[6] Sort the linked list.\n"
					  "\t[7] Search for a value.\n"
					  "\t[8] Join two linked lists.\n"
					  "\t[9] Backwards travel.\n"
					  "\t[w] Write the list to a file.\n"
					  "\t[r] Read the list from a file.\n"
					  "Option:";
	printf("%s", welcome_message);

	char option;
	while (option = getchar()) {
		switch (option) 
		{
			case 's':
				print_available_storage(p_array, selected_list_index);
				select_new_storage(p_array, &selected_list_index);
				break;

			case 'q':
				print_available_storage(p_array, selected_list_index);
				break;

			case 'p':
				print_list(p_array[selected_list_index]);
				break;

			case '1':
				printf("\tProvide a value: ");	
				scanf("%d", &value);
				append(&p_array[selected_list_index], value);
				break;

			case '2':
				printf("\tProvide a value: ");
				scanf("%d", &value);
				prepend(&p_array[selected_list_index], value);
				break;

			case '3':
				reverse(&p_array[selected_list_index]);
				printf("\tList reversed.\n");
				break;

			case '4':
				printf("\tProvide the value and the index: ");
				scanf("%d %d", &value, &index);
				add_nth_element(&p_array[selected_list_index], index, value);
				break;

			case '5':
				printf("\tProvide the index: ");
				scanf("%d", &index);
				remove_nth_element(&p_array[selected_list_index], index);
				break;

			case '6':
				insertion_sort(&p_array[selected_list_index]);
				printf("\tList sorted.\n");
				break;

			case '7':
				printf("\tProvide the searched value: ");
				scanf("%d", &searched_value);
				int v = search_value(&p_array[selected_list_index], searched_value);
				printf("We found %d\n", v);
				break;
			
			case '8':
				printf("\tChoose two lists you want to join together.\n");
				print_available_storage(p_array, selected_list_index);

				node_t* list1 = NULL;
				node_t* list2 = NULL;
				index = 0;
				printf("The first list: ");
				scanf("%d", &index);
				list1 = p_array[index];
				printf("\n");

				printf("The second list: ");
				scanf("%d", &index);
				list2 = p_array[index];
				printf("\n");

				printf("Pick a storage, for the joined list.\n");
				printf("Storage: ");
				scanf("%d", &selected_list_index);
				p_array[selected_list_index] = join_lists(list1, list2);
				break;

			case '9':
				printf("First we need to create a double linked list.\n");
				printf("Provide some values:\n");
				char c;
				dnode_t* head = NULL;
				dnode_t* curr_node = NULL;
				while (c = getchar())
				{
					if (c == ' ')
						break;
					if (c == '\n')
						continue;
					if ('0' <= c <= '9')
						d_append(&head, (c-'0'));
				}
				printf("You have created the following list:\n");
				d_print_list(head);

				printf("Choose the index from which to travel backwards.\n");
				scanf("%d", &index);	
				curr_node = head;
				for (int i = 1; i < index && curr_node != NULL; i++)
					curr_node = curr_node->next;		
				backwards_travel(curr_node);
				break;

			case 'w':
				printf("The selected storage will be loaded into a file.\n");
				current_node = p_array[selected_list_index]; 

				FILE* write_file;
				write_file = fopen("src/linked_list.txt", "w");
				if (write_file == NULL)
					printf("Failed at opening the file.\n");
				else 
				{
					while (current_node != NULL)
					{
						fprintf(write_file, "%d -> ", current_node->value);	
						current_node = current_node->next;
					}
					fprintf(write_file, "NULL\n");
				}
				fclose(write_file);
				break;
			
			case 'r':
				print_available_storage(p_array, selected_list_index);
				select_new_storage(p_array, &selected_list_index);

				FILE* read_file;
				read_file = fopen("src/linked_list.txt", "r");
				if (read_file == NULL)
					printf("Failed at opening the file.\n");
				else 
				{
					char buffer[BUFFER_SIZE];
					while (fscanf(read_file, "%s\n", buffer) == 1)
					{
						if (strcmp("NULL", buffer) == 0)
							break;
						if (strcmp("->", buffer) == 0)
							continue;

						value = atoi(buffer);
						append(&p_array[selected_list_index], value);
					}
				}
				printf("The list was loaded from the file.\n");
				fclose(read_file);
				break;

			default:
				printf("\n\nOption: ");
				break;
		}
	}

	return 0;
}