# Numele executabilului final
EXEC = main

# Găsește toate fișierele .c din directorul curent
SRC = $(wildcard *.c)

# Înlocuiește .c cu .o pentru a obține fișierele obiect
OBJ = $(SRC:.c=.o)

# Compilator și opțiuni
CC = gcc
CFLAGS = -Wall -Wextra -g

# Regulă implicită
all: $(EXEC)

# Link editor: crează executabilul din fișierele .o
$(EXEC): $(OBJ)
	$(CC) $(CFLAGS) -o $@ $^

# Compilare fișiere sursă în fișiere obiect
%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

# Curățare fișiere intermediare și executabil
clean:
	rm -f *.o $(EXEC)

# Curățare completă (inclusiv fișiere backup)
dist-clean: clean
	rm -f *~

.PHONY: all clean dist-clean
