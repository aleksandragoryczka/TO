from sectionZero.synop import *
from sectionZero.date import *

class SynopCollection(Synop):
    def __init__(self, length, content):
        for i in range(length-1):
            dict[i: Synop(i, length, content)]