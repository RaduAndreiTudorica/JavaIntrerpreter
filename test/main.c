#include <stdio.h>
#include "list.h"

int main() {
    List myList = init();

    myList = insert(myList, 10, 0);
    myList = insert(myList, 20, 1);
    myList = insert(myList, 30, 2);

    printf("List after insertions: ");
    Node current = myList->head;
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");

    myList = deleteNode(myList, 1);

    printf("List after deletion: ");
    current = myList->head;
    while (current != NULL) {
        printf("%d ", current->data);
        current = current->next;
    }
    printf("\n");

    return 0;
}