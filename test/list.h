#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#ifndef LIST_H
#define LIST_H

typedef struct Node {
    int data;
    struct Node* next;
    struct Node* prev;
} *Node;

typedef struct List{
    Node head;
    Node tail;
} *List;

List init() {
    List list = (List)malloc(sizeof(struct List));
    if (list == NULL) {
        printf("Memory allocation failed\n");
        return NULL;
    }
    list->head = NULL;
    list->tail = NULL;
    return list;
}
Node initNode() {
    Node node = (Node)malloc(sizeof(struct Node));
    if (node == NULL) {
        printf("Memory allocation failed\n");
        return NULL;
    }
    node->next = NULL;
    node->prev = NULL;
    return node;
}

Node createNode(int data) {
    Node node = initNode();
    if (node == NULL) {
        return NULL;
    }
    node->data = data;
    return node;
}

List insert(List list, int data, int position) {
    if (position < 0) {
        printf("Invalid position\n");
        return NULL;
    }

    Node newNode = createNode(data);

    if (newNode == NULL) {
        return NULL;
    }

    if(list == NULL) {
        list = init();
        if (list == NULL) {
            free(newNode);
            return NULL;
        }

        list->head = newNode;
        list->tail = newNode;
        return list;
    }

    if(list->head == NULL) {
        list->head = newNode;
        list->tail = newNode;
        return list;
    } else {
        Node current = list->head;
        int index = 0;

        while(current != NULL && index < position) {
            current = current->next;
            index++;
        }

        if (current == NULL) {
            // Insert at the end
            list->tail->next = newNode;
            newNode->prev = list->tail;
            list->tail = newNode;
        } else {
            // Insert in the middle
            newNode->next = current;
            newNode->prev = current->prev;
            if (current->prev != NULL) {
                current->prev->next = newNode;
            }
            current->prev = newNode;
        }
    }

    return list;
}

List deleteNode(List list, int position) {
    if (list == NULL || list->head == NULL || position < 0) {
        printf("Invalid operation\n");
        return list;
    }

    Node current = list->head;
    int index = 0;

    while(current != NULL && index < position) {
        current = current->next;
        index++;
    }

    if (current == NULL) {
        printf("Position out of bounds\n");
        return list;
    }

   if (current == list->head) {
       list->head = current->next;
       if (list->head != NULL) {
           list->head->prev = NULL;
       }
   } else if (current == list->tail) {
       list->tail = current->prev;
       if (list->tail != NULL) {
           list->tail->next = NULL;
       }
   } else {
       current->prev->next = current->next;
       current->next->prev = current->prev;
   }

   free(current);
   return list;
}

#endif