from password.PasswordManage import *
import bcrypt


# zakodowywanie
class PasswordEncoding(PasswordManage):

    def password_operation(self, pass_string: str) -> bytes:
        bytes = pass_string.encode("utf-8")

        encoded_password = bcrypt.hashpw(bytes, bcrypt.gensalt())

        return encoded_password
