# APJ Lab 6: Exception Handling

Application Programming in Java, INHA University in Tashkent, Fall 2026.

An employee management system built on an abstract `Employee` class with the `Payable` and `Taxable` interfaces (Lab 5), extended with exception handling:

- constructors and setters reject negative salaries, bonuses, hours and hourly rates with `throw new IllegalArgumentException(...)`;
- `main` creates the employees inside `try`, catches `IllegalArgumentException` and prints `getMessage()`;
- a `finally` block always prints "Employee processing completed."

**Run:** compile and run `src/U2510164_lab6.java`.
