from sectionzero.Date import Date

class DateParser():
    def __init__(self):
        dd = Date()
        self.datetimes_dictionary = dd.return_date()
        self.returned_dictionary = {}

    def parse_dates(self, beginning_date, end_date):
        keys_list = []
        for key, value in self.datetimes_dictionary.items():
            if beginning_date < value < end_date:
                keys_list.append(key)
        return keys_list
