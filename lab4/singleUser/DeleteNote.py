from singleUser.SingleUser import SingleUser


class DeleteNote(SingleUser):
    def operation_on_note(self, arg_list: list) -> None:
        query = "DELETE FROM notes WHERE idnotes = (%s)  "

        my_cursor = self.db.cursor()
        my_cursor.execute(query, arg_list)
        self.db.commit()
