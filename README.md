Spring JDBC is a powerful mechanism to connect to the database and executes the SQL queries.
- Spring JDBC provide JdbcTemplate class that contains all the important methods to perform operation with database.
- The main methods provided by JdbcTemplate are:
  1. update() -> used for insert, delete, update
  2. execute() -> select queries
  - Insert, Update and Delete operation can be simply performed by creating the Dao Interface and by providing the implementation for it.
    (**Dao** is a design pattern separates the business logic from the data acess logic, making the code more modular and maintainable.)
  - Select operation requires the additional RowMapper Interface and its implemenatation.
    (**RowMapper** is an interface that is used to convert the resultSet into an object.)
    Two methods are used for selecting objects:
    (i) For Single Object-
    public <T> queryForObject(String query, RowMapper<T> rowMapper, Object args)
    (ii) For multiple Objects-
    pubic List<T> query(String query, RowMapper<T> rowmMapper)
- We can configure the bean to use Spring Jdbc concepts by using any of the given method:
  1. By using xml config file
  2. By using Annotations
