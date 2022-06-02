
class Intern(val weeklyWorkload: Int) {
    val baseWorkload = 20

    class Salary {
        val basePay = 50.0
        val extraHoursPay = 2.8
    }

    val salary = Salary()
    val weeklySalary = if (weeklyWorkload == baseWorkload) salary.basePay else (salary.basePay + ((weeklyWorkload - baseWorkload) * salary.extraHoursPay))
}
