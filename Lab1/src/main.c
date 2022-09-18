#include <stdio.h>
#include <stdlib.h>
#include "linkedlistutils.h"
#include "doublylinkedlistutils.h"

#define NUMBER_OF_LISTS 5 

void demonstrate_how_functions_work() {
	// create a linked list.
	node_t* head = NULL;
	node_t* second = NULL;
	node_t* third = NULL;

	head   = (node_t*) malloc(sizeof(node_t));
	second = (node_t*) malloc(sizeof(node_t));
	third  = (node_t*) malloc(sizeof(node_t));

	head->value = 1;
	head->next = second;

	second->value = 2;
	second->next = third;

	third->value = 3;
	third->next = NULL;

	print_list(head);
	printf("\n");

	// show Append function
	append(&head, 4);
	print_list(head);
	printf("\n");

	// show Prepend function
	prepend(&head, 5);
	print_list(head);
	printf("\n");

	// show Reverse function
	reverse(&head);
	print_list(head);
	printf("\n");

	// Add a value to the specific index
	add_nth_element(&head, 3, 10);
	print_list(head);
	printf("\n");

	// Remove a value the from index
	remove_nth_element(&head, 3);
	print_list(head);
	printf("\n");

	// Sort the linked list, with re-arranging the cells, not just copying values
	insertion_sort(&head);
	printf("\n");

	// Search for a value
	int v = search_value(&head, 4);
	printf("We have found %d\n", v);
	printf("\n");

	// Join two linked lists 
	node_t* list1 = NULL;
	append(&list1, 1);
	append(&list1, 2);
	append(&list1, 3);

	node_t* list2 = NULL;
	append(&list2, 4);
	append(&list2, 5);
	append(&list2, 6);

	printf("The list are not joined.\n");
	print_list(list1);
	print_list(list2);

	printf("Joining the lists.\n");
	node_t* joined_list = join_lists(list1, list2);
	print_list(joined_list);
	printf("\n");


	// Backwards traversal, use double-linked-list
	dnode_t* double_linked_list = NULL;
	d_append(&double_linked_list, 7);
	d_append(&double_linked_list, 2);
	d_append(&double_linked_list, 3);
	d_append(&double_linked_list, 4);
	d_append(&double_linked_list, 5);

	d_print_list(double_linked_list);
	backwards_travel(double_linked_list->next->next->next);
}

int main() {
	// demonstrate_how_functions_work();	
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
				printf("Pick a new storage.\n");
				printf("Storage: ");
				scanf("%d", &selected_list_index);
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
				break;

			case 'q':
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
				printf("Available storages.\n");
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
				FILE* read_file;
				read_file = fopen("src/linked_list.txt", "r");
				if (read_file == NULL)
					printf("Failed at opening the file.\n");
				else 
				{
					char buffer[500];
					while (fscanf(read_file, "%s\n", buffer) == 1)
						printf("%s", buffer);
					printf("\n");
				}
				fclose(read_file);
				break;


			default:
				printf("\nPick up an option from the list above.\nOption: ");
				break;
		}
	}

	return 0;
}