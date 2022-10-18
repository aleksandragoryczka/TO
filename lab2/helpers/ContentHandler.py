import helpers
from helpers.DataProvider import *

class ContentHandler(DataProvider):
    def __init__(self):
       # super().__init__()
        DataProvider.__init__(self)
        self.content, self.len = DataProvider.getData(self)