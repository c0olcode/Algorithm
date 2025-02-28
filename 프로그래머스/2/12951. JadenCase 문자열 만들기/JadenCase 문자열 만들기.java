class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true; // 단어의 첫 문자 여부 판단

        for (char c : s.toCharArray()) {
            if (c == ' ') { // 공백은 그대로 추가하고, 다음 문자를 단어의 첫 글자로 인식
                sb.append(c);
                isFirst = true;
            } else {
                if (isFirst) {
                    sb.append(Character.toUpperCase(c)); // 첫 문자 대문자로 변환
                } else {
                    sb.append(Character.toLowerCase(c)); // 나머지는 소문자로 변환
                }
                isFirst = false;
            }
        }

        return sb.toString();
    }
}
