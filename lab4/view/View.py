from singleUser.EditNote import EditNote
from singleUser.DeleteNote import DeleteNote
from singleUser.InsertNote import InsertNote
from singleUser.ReadNote import ReadNote
from users.LogInUser import *
from users.InsertUser import *


def menu_notes() -> None:
    print("\nCo chesz zrobić?")
    print("1 - Dodać notatkę")
    print("2 - Odczytać notatki")
    print("3 - Edytować notatkę")
    print("4 - Usunąć notatkę")
    print("5 - Wyjście")


def main_menu() -> str:
    print("\nCo chcesz zrobić?")
    print("1 - Zaloguj się")
    print("2 - Zarejstruj się")
    print("3 - Zakończ")
    ch = input("Twój wybór: ")
    return ch


def read(id: int) -> bool:
    single_user = ReadNote(id)
    notes = single_user.operation_on_note([]).fetchall()
    if len(notes) == 0:
        print("Brak notatek.\n")
        return False
    for note in notes:
        print("Nr: " + str(note[0]) + "\nTytuł: " + note[1] + "\n" + note[2] + "\n")
    return True


class View:

    @staticmethod
    def view() -> None:

        ch = main_menu()

        while ch != "3":
            if ch == "1":
                login = input("Login: ")
                password = input("Hasło: ")

                logged = LogInUser()
                if logged.user_operation([login, password]):
                    flag = True
                    print("Udało Ci się zalogować!")
                    while flag:
                        id = logged.user_operation([login, password])
                        menu_notes()
                        ch = input("Twój wybór: ")
                        if ch == "1":
                            title = input("Tytuł notatki: ")
                            content = input("Treść notatki: ")
                            single_user = InsertNote(id)
                            single_user.operation_on_note([title, content])
                        if ch == "2":
                            read(id)
                        if ch == "3":
                            if read(id):
                                edited_note_id = int(input("Którą notatkę chcesz edytować?\nPodaj nr: "))
                                new_title = input("Podaj nowy tytuł: ")
                                new_content = input("Podaj nową treść: ")
                                single_user = EditNote(id)
                                single_user.operation_on_note([new_title, new_content, edited_note_id])
                        if ch == "4":
                            if read(id):
                                deleted_note_id = int(input("Którą notatkę chcesz usunąć?\nTwój wybór: "))
                                single_user = DeleteNote(id)
                                single_user.operation_on_note([deleted_note_id])
                        if ch == "5":
                            flag = False
                else:
                    ch = main_menu()

            if ch == "2":
                name = input("Imię: ")
                surname = input("Nazwisko: ")
                login = input("Login: ")
                password = input("Hasło: ")
                new_user = InsertUser()
                new_user.user_operation([name, surname, login, password])
                print("Udało Ci się zarejestrować!\nZaloguj się.")
                ch = 1
            if "ch" == "3":
                print("KONIEC")
                exit(0)
            else:
                ch = main_menu()
