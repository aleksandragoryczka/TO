from singleUser.SingleUser import SingleUser


class EditNote(SingleUser):
    def operation_on_note(self, arg_list: list) -> None:
        query = "UPDATE notes SET note_title = (%s), note_content = (%s) WHERE idnotes = (%s) "

        my_cursor = self.db.cursor()
        my_cursor.execute(query, arg_list)
        self.db.commit()
