from abc import ABC, abstractmethod


class PasswordManage(ABC):
    def __init__(self):
        pass

    @abstractmethod
    def password_operation(self, pass_string: str):
        pass
