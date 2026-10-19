class Solution:
    def dayOfYear(self, date: str) -> int:
        year = int(date[0:4])
        month = int(date[5:7])
        day = int(date[8:10])
        days_passed = [0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334]
        total_days = days_passed[month] + day
        if month > 2 and ((year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)):
            total_days += 1
        return total_days
