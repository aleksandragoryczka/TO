from abc import ABC

import mysql.connector.errors

from users.Users import *
from connection import *
from password.PasswordDecoding import *

from lab4.users.Users import Users


class LogInUser(Users, ABC):

    def user_operation(self, arg_list: list):
        try:
            query = "SELECT password_user, idusers from users where login_user = (%s) "

            my_cursor = self.db.cursor(buffered=True)
            my_cursor.execute(query, [arg_list[0]])

            (password_from_db, user_id) = my_cursor.fetchall()[0]

            password_decoding = PasswordDecoding(password_from_db)

            if password_decoding.password_operation(arg_list[-1]):
                return user_id
            else:
                print("Podałeś niepoprawne hasło.\n")
                return False

        except mysql.connector.errors.ProgrammingError:
            print("Użytkownik o tym loginie nie istnieje.\nSpróbuj ponownie.\n")
            return False
        except IndexError:
            print("Użytkownik o tym loginie nie istnieje.\nSpróbuj ponownie.\n")
            return False

