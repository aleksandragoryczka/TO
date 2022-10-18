from datetime import datetime
from helpers import *

class Date(ContentHandler):
    def __init__(self):
        super().__init__()
        self.string_date = []
        for i in range(self.len-1):
            self.string_date.append(self.content[i][0:5])

    def return_date(self):
        datetimes_dictionary = {}
        for count,line in enumerate(self.string_date):
            datetimes_dictionary[count] = datetime(year = int(line[0]), month =  int(line[1]), day =  int(line[2]), hour =  int(line[3]), minute = int(line[4]))
        return datetimes_dictionary

