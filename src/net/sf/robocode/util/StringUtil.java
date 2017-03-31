package net.sf.robocode.util;










public final class StringUtil
{
  public StringUtil() {}
  








  public static String toBasicLatin(CharSequence sequence)
  {
    StringBuilder out = new StringBuilder();
    
    for (int i = 0; i < sequence.length(); i++) {
      char ch = sequence.charAt(i);
      
      if (Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.BASIC_LATIN) {
        out.append(ch);
      } else {
        int codepoint = Character.codePointAt(sequence, i);
        

        i += Character.charCount(codepoint) - 1;
        
        out.append(String.format("\\u%1$04X", new Object[] { Integer.valueOf(codepoint) }));
      }
    }
    return out.toString();
  }
  






  public static int countChar(String str, char chr)
  {
    int count = 0;
    for (char c : str.toCharArray()) {
      if (c == chr) {
        count++;
      }
    }
    return count;
  }
}
