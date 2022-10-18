from helpers.ContentHandler import *

#4, 13
class Sixth(ContentHandler): 
    def __init__(self):
        self.tmp_string = []
        ContentHandler.__init__(self)
        for i in range(self.len-1):
            self.tmp_string.append(self.content[i][13])

    def return_pressure_sea(self):
        dictionary = {}
        for count,line in enumerate(self.tmp_string):
                dictionary[count] = str(int(line[1:])* 0.1) + " hPa"
        return dictionary
    