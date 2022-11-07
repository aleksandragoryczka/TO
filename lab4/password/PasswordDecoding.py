import bcrypt

from password.PasswordManage import PasswordManage
from connection import *


#odkodowanie
class PasswordDecoding(PasswordManage):
    def __init__(self, password_db):
        self.password_db = password_db.encode("utf-8")

    def password_operation(self, pass_string: str) -> bool:
        user_bytes = pass_string.encode("utf-8")

        return bcrypt.checkpw(user_bytes, self.password_db)
