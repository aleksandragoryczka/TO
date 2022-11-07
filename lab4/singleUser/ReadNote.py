from singleUser.SingleUser import SingleUser


class ReadNote(SingleUser):
    def operation_on_note(self, arg_list: list) -> object:
        query = "SELECT idnotes, note_title, note_content from notes WHERE iduser = (%s) "

        my_cursor = self.db.cursor()
        my_cursor.execute(query, (self.user_id,))
        return my_cursor







