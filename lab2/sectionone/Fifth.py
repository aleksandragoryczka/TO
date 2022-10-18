from helpers.ContentHandler import *

#3, 12
class Fifth(ContentHandler): 
    def __init__(self):
        self.tmp_string = []
        ContentHandler.__init__(self)
        for i in range(self.len-1):
            self.tmp_string.append(self.content[i][12])

    def return_pressure_station(self):
        dictionary = {}
        for count,line in enumerate(self.tmp_string):
                dictionary[count] = str(int(line[1:])* 0.1) + " hPa"
        return dictionary
    