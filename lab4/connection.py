import mysql.connector as conn


class DatabaseConnection:
    def __init__(self):
        self.db = conn.connect(
            host="localhost",
            user="root",
            password="root",
            database="lab4"
        )

        self.my_cursor = self.db.cursor()
