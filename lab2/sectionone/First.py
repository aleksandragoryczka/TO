from helpers.ContentHandler import *

class First(ContentHandler):
    def __init__(self):
        self.tmp_string = []
        ContentHandler.__init__(self)
        for i in range(self.len-1):
            self.tmp_string.append(self.content[i][8])

    def return_rain_group_indicator(self):
        rain_group_indicator_dictionary = {}
        for count,line in enumerate(self.tmp_string):
            rain_group_indicator_dictionary[count] = line[0]
        return rain_group_indicator_dictionary

    def return_station_type(self):
        station_type_dictionary = {}
        for count,line in enumerate(self.tmp_string):
            station_type_dictionary[count] = line[1]
        return station_type_dictionary

    def return_relative_height(self):
        relative_height_dictionary = {}
        for count,line in enumerate(self.tmp_string):
            relative_height_dictionary[count] = line[2]
        return relative_height_dictionary

    def return_visibility(self):
        visibilities_dictionary = {}
        for count,line in enumerate(self.tmp_string):
            visibilities_dictionary[count] = line[3:]
        return visibilities_dictionary