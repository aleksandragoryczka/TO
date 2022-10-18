from helpers.ContentHandler import *

#2, 11
class Fourth(ContentHandler): 
    def __init__(self):
        self.tmp_string = []
        ContentHandler.__init__(self)
        for i in range(self.len-1):
            self.tmp_string.append(self.content[i][11])

    def return_dewpoint_temperature(self):
        dictionary = {}
        for count,line in enumerate(self.tmp_string):
            if line[1] == 1:
                dictionary[count] = "- " + str(int(line[2:])* 0.1) + " °C"
            else:
                dictionary[count] = "+ " + str(int(line[2:])* 0.1) + " °C"
        return dictionary
    