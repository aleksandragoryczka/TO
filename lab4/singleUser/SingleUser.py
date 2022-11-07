from abc import abstractmethod

from connection import DatabaseConnection


class SingleUser(DatabaseConnection):
    def __init__(self, user_id: int):
        super().__init__()
        self.user_id = user_id

    @abstractmethod
    def operation_on_note(self, arg_list: list):
        pass
