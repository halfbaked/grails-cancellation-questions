databaseChangeLog = {

	changeSet(author: "eamonnoconnell (generated)", id: "1373285996921-1") {
		createTable(tableName: "cancellation_answer") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "cancellation_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_email", type: "varchar(255)")

			column(name: "account_name", type: "varchar(255)")

			column(name: "body", type: "longvarchar")

			column(name: "created_date", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "longvarchar") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "eamonnoconnell (generated)", id: "1373285996921-2") {
		createTable(tableName: "cancellation_question") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "cancellation_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "body", type: "longvarchar")

			column(name: "created_date", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "longvarchar") {
				constraints(nullable: "false")
			}
		}
	}
}
