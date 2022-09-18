typedef struct d_node {
    int value;
    struct d_node* next;
    struct d_node* prev;
} dnode_t;

void d_print_list(dnode_t* nth_element) {
    while (nth_element != NULL)
    {
        printf(" %d ", nth_element->value);
        nth_element = nth_element->next;
    }
    printf("NULL\n");
}

void d_append(dnode_t** head, int value) {
    dnode_t* current_node = NULL;
    dnode_t* previous_node = NULL;

    if (*head == NULL)
    {
        *head = (dnode_t*) malloc(sizeof(dnode_t));
        if (*head == NULL)
        {
            printf("\n[INFO] Error while mallocing memory, in `d_append`.\n");
            return;
        }
        (*head)->value = value;
        (*head)->prev = NULL;
        (*head)->next = NULL;
        return;
    }

    current_node = *head;
    while (current_node->next != NULL)
    {
        previous_node = current_node;
        current_node = current_node->next;
    }

    current_node->next = (dnode_t*) malloc(sizeof(dnode_t));
    if (current_node->next == NULL)
    {
        printf("\n[INFO] Error while mallocing memory, in `d_append`.\n");
        return;
    }

    current_node->next->value = value;
    current_node->next->next = NULL;
    current_node->next->prev = current_node;
}

void backwards_travel(dnode_t* nth_element) {
    while (nth_element != NULL)
    {
        printf(" %d ", nth_element->value);
        nth_element = nth_element->prev;
    }
    printf("NULL\n");
} 

