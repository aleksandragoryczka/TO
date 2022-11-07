from users.Users import *
from password.PasswordEncoding import *
import mysql.connector
from connection import *


class InsertUser(Users):
    def user_operation(self, arg_list: list) -> None:
        passwd = PasswordEncoding()
        arg_list[-1] = passwd.password_operation(arg_list[-1])
        query = "INSERT INTO users (name_user, surname_user, login_user, password_user) VALUES (%s, %s, %s, %s) "

        my_cursor = self.db.cursor(buffered=True)
        my_cursor.execute(query, arg_list)
        self.db.commit()



