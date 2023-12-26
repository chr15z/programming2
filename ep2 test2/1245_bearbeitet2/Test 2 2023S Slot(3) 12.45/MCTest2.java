// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf gut gewählte Kommentare in Programmen zu?",

                        new Choice(false, "Vorbedingungen stehen hauptsächlich vor Methodenköpfen.                            (1A)"),
                        new Choice(false, "Die meisten Kommentare beschreiben, wie Anweisungen zu lesen sind.                 (1B)"),
                        new Choice(false, "Kommentare sollen sich auf die Außensicht konzentrieren.                           (1C)"),
                        new Choice(false, "Besonders wenige Kommentare deuten auf schlecht designte Stellen hin.              (1D)"),
                        new Choice(false, "Invarianten stehen hauptsächlich bei Variablendeklarationen.                       (1E)")
                ),

                new Question(
                        "int w=86, y=1, k=1; while (k < w) y *= ++k; \n" +
                        "Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?",

                        new Choice(false, "y >= k                                                                             (2A)"),
                        new Choice(false, "y >= w                                                                             (2B)"),
                        new Choice(false, "k > 0 && k < w                                                                     (2C)"),
                        new Choice(false, "y ist das Produkt aller Zahlen von 1 bis w, also 1*...*w                           (2D)"),
                        new Choice(false, "w == 86                                                                            (2E)")
                ),

                new Question(
                        "n, o und p seien Objektreferenzen ungleich null.\n" +
                        "Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
                        "boolean equals(Object obj)  und  int hashCode()  in Java gelten?",

                        new Choice(false, "Aus  o.hashCode() != p.hashCode()  folgt  !o.equals(p).                            (3A)"),
                        new Choice(false, "o.equals(null)  gibt  false  zurück.                                               (3B)"),
                        new Choice(false, "null.equals(o)  gibt  false  zurück.                                               (3C)"),
                        new Choice(false, "Aus  n.equals(o)  und  o.equals(p)  folgt  n.equals(p).                            (3D)"),
                        new Choice(false, "Aus  o.equals(p)  folgt  o.hashCode() == p.hashCode().                             (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?",

                        new Choice(false, "Ausnahmen vom Typ RuntimeException sind überprüft (checked).                       (4A)"),
                        new Choice(false, "Das Ergebnis von getMessage() bestimmt den Typ einer Exception.                    (4B)"),
                        new Choice(false, "Alle Ausnahmen sind vom Typ Throwable.                                             (4C)"),
                        new Choice(false, "Gibt es mehrere catch-Blöcke, wird der erste passende ausgeführt.                  (4D)"),
                        new Choice(false, "Jeder Programmabbruch endet in der Ausgabe eines Stack-Trace.                      (4E)")
                ),

                new Question(
                        "public int median(int[] o) { return o[o.length / 2]; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Nachbedingung: o ist aufsteigend sortiert.                                         (5A)"),
                        new Choice(false, "Nachbedingung: Wirft eine Exception wenn o.length == 0.                            (5B)"),
                        new Choice(false, "Nachbedingung: Halbiert die Länge von o.                                           (5C)"),
                        new Choice(false, "Nachbedingung: Gibt einen Eintrag etwa in der Mitte von o zurück.                  (5D)"),
                        new Choice(false, "Nachbedingung: Ergebnis hängt von einem Eintrag von o ab.                          (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf gut gewählte Kommentare in Programmen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Vorbedingungen stehen hauptsächlich vor Methodenköpfen.                            (1A)\n" +
            "    XXXXXXXXX Die meisten Kommentare beschreiben, wie Anweisungen zu lesen sind.                 (1B)\n" +
            "    XXXXXXXXX Kommentare sollen sich auf die Außensicht konzentrieren.                           (1C)\n" +
            "    XXXXXXXXX Besonders wenige Kommentare deuten auf schlecht designte Stellen hin.              (1D)\n" +
            "    XXXXXXXXX Invarianten stehen hauptsächlich bei Variablendeklarationen.                       (1E)\n" +
            "\n" +
            " 2. int w=86, y=1, k=1; while (k < w) y *= ++k; \n" +
            "    Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?\n" +
            "    \n" +
            "    XXXXXXXXX y >= k                                                                             (2A)\n" +
            "    XXXXXXXXX y >= w                                                                             (2B)\n" +
            "    XXXXXXXXX k > 0 && k < w                                                                     (2C)\n" +
            "    XXXXXXXXX y ist das Produkt aller Zahlen von 1 bis w, also 1*...*w                           (2D)\n" +
            "    XXXXXXXXX w == 86                                                                            (2E)\n" +
            "\n" +
            " 3. n, o und p seien Objektreferenzen ungleich null.\n" +
            "    Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
            "    boolean equals(Object obj)  und  int hashCode()  in Java gelten?\n" +
            "    \n" +
            "    XXXXXXXXX Aus  o.hashCode() != p.hashCode()  folgt  !o.equals(p).                            (3A)\n" +
            "    XXXXXXXXX o.equals(null)  gibt  false  zurück.                                               (3B)\n" +
            "    XXXXXXXXX null.equals(o)  gibt  false  zurück.                                               (3C)\n" +
            "    XXXXXXXXX Aus  n.equals(o)  und  o.equals(p)  folgt  n.equals(p).                            (3D)\n" +
            "    XXXXXXXXX Aus  o.equals(p)  folgt  o.hashCode() == p.hashCode().                             (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Ausnahmen vom Typ RuntimeException sind überprüft (checked).                       (4A)\n" +
            "    XXXXXXXXX Das Ergebnis von getMessage() bestimmt den Typ einer Exception.                    (4B)\n" +
            "    XXXXXXXXX Alle Ausnahmen sind vom Typ Throwable.                                             (4C)\n" +
            "    XXXXXXXXX Gibt es mehrere catch-Blöcke, wird der erste passende ausgeführt.                  (4D)\n" +
            "    XXXXXXXXX Jeder Programmabbruch endet in der Ausgabe eines Stack-Trace.                      (4E)\n" +
            "\n" +
            " 5. public int median(int[] o) { return o[o.length / 2]; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Nachbedingung: o ist aufsteigend sortiert.                                         (5A)\n" +
            "    XXXXXXXXX Nachbedingung: Wirft eine Exception wenn o.length == 0.                            (5B)\n" +
            "    XXXXXXXXX Nachbedingung: Halbiert die Länge von o.                                           (5C)\n" +
            "    XXXXXXXXX Nachbedingung: Gibt einen Eintrag etwa in der Mitte von o zurück.                  (5D)\n" +
            "    XXXXXXXXX Nachbedingung: Ergebnis hängt von einem Eintrag von o ab.                          (5E)\n" +
            "\n";

    public static final long UID = 247158650295804L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i++, scanner.nextLine());
            while (scanner.hasNextLine()) {
                s += String.format("    %s\n", scanner.nextLine());
            }
            s += "\n";
        }
        String converted = s.replace("Richtig: ", "XXXXXXXXX").replace("Falsch:  ", "XXXXXXXXX");
        if (!converted.replaceAll("[ \t]+", " ").equals(EXPECT.replaceAll("[ \t]+", " "))) {
            i = 0;
            String err = "\n";
            java.util.Scanner e = new java.util.Scanner(EXPECT);
            java.util.Scanner f = new java.util.Scanner(converted);
            while (e.hasNextLine() && f.hasNextLine() && i < 5) {
                String el = e.nextLine(), fl = f.nextLine();
                if (!el.replaceAll("[ \t]+", " ").equals(fl.replaceAll("[ \t]+", " "))) {
                    i++;
                    err += "Statt der Zeile: " + fl + "\nsollte stehen:   " + el + "\n\n";
                }
            }
            if (i >= 5) {
                err = "Das sind die erwarteten Fragen und Antwortmöglichkeiten in 'EXPECT':\n\n" + EXPECT;
            }
            System.out.println("ACHTUNG: Sie haben Programmteile verändert, die nicht geändert werden sollten.\n" +
                    "Beurteilt wird so, als ob diese Programmteile unverändert geblieben wären.\n" +
                    err);
            System.exit(1);
        }
        System.out.print("Die Multiple-Choice-Fragen wurden folgendermaßen beantwortet\n" +
                "(das sind nur Ihre Antworten, keine Aussage über Korrektheit):\n\n" +
                s);
        System.exit(0);
    }

    private static class Question {
        private final String question;
        private final Choice[] choices;

        public Question(String question, Choice... choices) {
            this.question = question;
            this.choices = choices;
        }

        public String toString() {
            String s = question + "\n\n";
            for (Choice choice : choices) {
                s += choice + "\n";
            }
            return s;
        }
    }

    private static class Choice {
        private final String answer;
        private final boolean valid;

        public Choice(boolean valid, String answer) {
            this.answer = answer;
            this.valid = valid;
        }

        public String toString() {
            return (valid ? "Richtig:  " : "Falsch:   ") + answer;
        }
    }
}