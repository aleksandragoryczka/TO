from helpers.ContentHandler import *

# 5, 14
class Seventh(ContentHandler):
    def __init__(self):
        self.tmp_string = []
        ContentHandler.__init__(self)
        for i in range(self.len-1):
            self.tmp_string.append(self.content[i][14])

    def return_tendency_atmosphere_pressure(self):
        dictionary = {}
        for count,line in enumerate(self.tmp_string):
            dictionary[count] = line[1]
        return dictionary

    def return_absolute_tendency_atmosphere_pressure(self):
        dictionary = {}
        for count,line in enumerate(self.tmp_string):
            dictionary[count] = str(int(line[2:].rstrip("="))* 0.1) + " hPa"
        return dictionary


    