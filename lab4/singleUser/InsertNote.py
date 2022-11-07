from singleUser.SingleUser import SingleUser


class InsertNote(SingleUser):
    def operation_on_note(self, arg_list: list) -> None:
        query = "INSERT INTO notes (note_title, note_content, iduser) VALUES (%s, %s, %s) "

        arg_list.append(self.user_id)

        my_cursor = self.db.cursor()
        my_cursor.execute(query, arg_list)
        self.db.commit()
