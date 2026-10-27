class Solution {
    public String maskPII(String s) {

        /*
        🔥 APPROACH: Case Handling (Email vs Phone)

        Step 1: Detect type
        - If contains '@' → Email
        - Else → Phone

        -----------------------------------
        📧 EMAIL:
        - Convert entire string to lowercase
        - Split into name + domain
        - Format:
            first + "*****" + last + "@" + domain

        -----------------------------------
        📞 PHONE:
        - Extract only digits
        - Last 10 digits → local number
        - Remaining digits → country code

        Format:
        - "***-***-XXXX" (no country code)
        - "+*-***-***-XXXX" (1 digit country)
        - "+**-***-***-XXXX" (2 digits)
        - "+***-***-***-XXXX" (3 digits)

        ⏱ Time: O(n)
        💾 Space: O(n)
        */

        // 🔥 Case 1: EMAIL
        if (s.indexOf('@') != -1) {

            s = s.toLowerCase();

            int at = s.indexOf('@');

            String name = s.substring(0, at);
            String domain = s.substring(at);

            // first + ***** + last
            return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + domain;
        }

        // 🔥 Case 2: PHONE
        StringBuilder digits = new StringBuilder();

        // extract digits only
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }

        int n = digits.length();

        // last 4 digits
        String last4 = digits.substring(n - 4);

        // local format
        String local = "***-***-" + last4;

        int countryLen = n - 10;

        // no country code
        if (countryLen == 0) {
            return local;
        }

        // build country prefix
        StringBuilder prefix = new StringBuilder("+");

        for (int i = 0; i < countryLen; i++) {
            prefix.append("*");
        }

        prefix.append("-");

        return prefix.toString() + local;
    }
}
