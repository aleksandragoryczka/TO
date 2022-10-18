from helpers.ContentHandler import *

class Second(ContentHandler):
    def __init__(self):
        self.tmp_string = []
        ContentHandler.__init__(self)
        for i in range(self.len-1):
            self.tmp_string.append(self.content[i][9])

    def return_cloudy_indicator(self):
        dictionary = {}
        for count,line in enumerate(self.tmp_string):
            dictionary[count] = line[0]
        return dictionary

    def return_wind_direction(self):
        dictionary = {}
        for count,line in enumerate(self.tmp_string):
            dictionary[count] = line[1:3]
        return dictionary

    def return_wind_speed(self):
        dictionary = {}
        for count,line in enumerate(self.tmp_string):
            dictionary[count] = line[-1]
        return dictionary

    