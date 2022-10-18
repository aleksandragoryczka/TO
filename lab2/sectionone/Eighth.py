from helpers.ContentHandler import *

#6, 15
class Eighth(ContentHandler):
    def __init__(self):
       # self.num = num
        ContentHandler.__init__(self)
        
    def return_total_precipitation(self,num):
        dictionary = {}
        for i in range(self.len-1):
            for el in self.content[i][14:]:
                if el.startswith(num):
                    dictionary[i] = el
        return dictionary
