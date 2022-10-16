from datetime import datetime
from helpers import *

class Date():
     # len - liczba pomiarow
    def __init__(self, len, content):
        self.stringDate = []
        for i in range(len-1):
            self.stringDate.append(content[i][0:5])

    def returnDate(self):
        listDatetimes = []
       # print(self.stringDate)
        for line in self.stringDate:
           # print(line[0])
            listDatetimes.append(datetime.datetime(year = int(line[0]), month =  int(line[1]), day =  int(line[2]), hour =  int(line[3]), minute = int(line[4])))
        return listDatetimes

