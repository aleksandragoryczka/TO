from abc import ABC, abstractmethod
from connection import *


class Users(ABC, DatabaseConnection):
    def __init__(self):
        super().__init__()

    @abstractmethod
    def user_operation(self, arg_list: list):
        pass
