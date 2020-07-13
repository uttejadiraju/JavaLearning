package joshuaBloschCodes;
public final class CaseInsensitiveString {
 private final String s;

 public CaseInsensitiveString(String s) {
     this.s = s;
 }

 // Broken - violates symmetry!
 @Override public boolean equals(Object o) {
     if (o instanceof CaseInsensitiveString)
         return s.equalsIgnoreCase(
                 ((CaseInsensitiveString) o).s);
     if (o instanceof String)  // One-way interoperability!
         return s.equalsIgnoreCase((String) o);
     return false;
 }

 // Demonstration of the problem (Page 40)
 public static void main(String[] args) {
     CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
     String s = "polish";
     System.out.println(cis.equals(s));
     System.out.println(s.equals(cis));
 }

}

/**
 * As expected, string.equals(string1) returns true. The problem is that while
 * the equals method in Str knows about ordinary strings, the equals method in
 * String is oblivious to case-insensitive strings. Therefore,
 * string1.equals(string) returns false, a clear violation of symmetry.
 */