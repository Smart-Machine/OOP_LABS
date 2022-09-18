typedef struct node {
	int value;
	struct node* next;
} node_t;

void print_list(node_t* nth_element) {
    while (nth_element != NULL)
    {
        printf(" %d ", nth_element->value);
        nth_element = nth_element->next;
    }
    printf("NULL\n");
}

void append(node_t** head, int value) {
    node_t* current_node = NULL;

    if (*head == NULL) 
    {
        *head = (node_t*) malloc(sizeof(node_t));
        if (*head == NULL)
        {
            printf("\n[INFO] Error while mallocing memory, in `append`.\n");
            return;
        }
        (*head)->value = value;
        (*head)->next = NULL;
        return;
    }

    current_node = *head;
    while (current_node->next != NULL)
        current_node = current_node->next;
    
    current_node->next = (node_t*) malloc(sizeof(node_t));
    if (current_node->next == NULL)
    {
        printf("\n[INFO] Error while mallocing memory, in `append`.\n");
        return;
    }

    current_node->next->value = value; 
    current_node->next->next = NULL;
}

void prepend(node_t** head, int value) {
    node_t* old_head = NULL;

    if (*head == NULL)
    {
        *head = (node_t*) malloc(sizeof(node_t));
        if (*head == NULL) 
        {
            printf("\n[INFO] Error while mallocing memory, in `prepend`.\n");
            return;
        }
        (*head)->value = value;
        (*head)->next = NULL;
        return;
    }

    old_head = *head;

    *head = (node_t*) malloc(sizeof(node_t));
    if (*head == NULL)
    {
        printf("\n[INFO] Error while mallocing memory, in `prepend`.\n");
        return;
    }

    (*head)->value = value;
    (*head)->next = old_head;
}

void reverse(node_t** head) {
    node_t* previous_node = NULL;
    node_t* current_node = *head;
    node_t* next_node = NULL;

    if (*head == NULL || (*head)->next == NULL)
        return;

    while (current_node != NULL)
    {
        next_node = current_node->next;
        current_node->next = previous_node;
        previous_node = current_node;
        current_node = next_node;
    }
    *head = previous_node;
}

void add_nth_element(node_t** head, int index, int value) {
    node_t* previous_node = NULL;
    node_t* current_node = *head;
    node_t* new_node = NULL;
    int current_index = 1;

    if (*head == NULL)
    {
       *head = (node_t*) malloc(sizeof(node_t));
        if (*head == NULL)
        {
            printf("\n[INFO] Error while mallocing memory, in `add_nth_element`.\n");
            return;
        }
        (*head)->value = value;
        (*head)->next = NULL;
        return; 
    }

    if (index == 1)
    {
        new_node = (node_t*) malloc(sizeof(node_t));
        if (new_node == NULL) 
        {
            printf("\n[INFO] Error while mallocing memory, in `add_nth_element`.\n");
            return;
        }
        new_node->value = value;
        new_node->next = *head;
        *head = new_node;
        return;
    }

    while (index > current_index++ && current_node != NULL)
    {
        previous_node = current_node;
        current_node = current_node->next;
    }

    new_node = (node_t*) malloc(sizeof(node_t));
    if (new_node == NULL) 
    {
        printf("\n[INFO] Error while mallocing memory, in `add_nth_element`.\n");
        return;
    }
    new_node->value = value;
    previous_node->next = new_node;
    new_node->next = current_node;
}

void remove_nth_element(node_t** head, int index) {
    node_t* previous_node = NULL;
    node_t* current_node = *head;
    node_t* next_node = NULL;
    int current_index = 1;

    if (*head == NULL)
        return;

    if (index == 1)
    {
        next_node = current_node->next;
        free(*head);
        *head = next_node;
        return;
    }

    while (index > current_index++ && current_node->next != NULL)
    {
        previous_node = current_node;
        current_node = current_node->next;
        next_node = current_node->next;
    }

    previous_node->next = next_node;
    free(current_node);
}

void insertion_sort(node_t** head) {
    node_t* current_node = *head;
    node_t* ith_node = NULL;
    node_t* next_node = NULL;
    node_t* sorted = NULL;

    printf("Sorting\n");

    while (current_node != NULL)
    {
        next_node = current_node->next;

        if (sorted == NULL || sorted->value >= current_node->value)
        {
            current_node->next = sorted;
            sorted = current_node;
        }
        else 
        {
            ith_node = sorted;
            while (ith_node->next != NULL && ith_node->next->value < current_node->value)
            {
                ith_node = ith_node->next;
            }
            current_node->next = ith_node->next;
            ith_node->next = current_node;
        }
        print_list(sorted);
        current_node = next_node;
    }
    *head = sorted;
}

int search_value(node_t** head, int searched_value) {
    node_t* current_node = *head;

    if (*head == NULL)
    {
        printf("\n[INFO] Empty list.\n");
        return 0;
    }

    while (current_node->next != NULL)
    {
        if (current_node->value == searched_value) 
            return current_node->value;
        current_node = current_node->next;
    }

    printf("\n[INFO] Value not found.\n");
    return 0;
}

node_t* join_lists(node_t* list1, node_t* list2) {
    node_t* joined_list = NULL;
    node_t* current_node = NULL;

    current_node = list1;
    while (current_node != NULL)
    {
        append(&joined_list, current_node->value);
        current_node = current_node->next;
    }
    current_node = list2;
    while (current_node != NULL)
    {
        append(&joined_list, current_node->value);
        current_node = current_node->next;
    }

    return joined_list;
}

