// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "int n=90, o=1, j=1; while (j < n) o *= ++j; \n" +
                        "Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?",

                        new Choice(true, "n == 90                                                                            (1A)"),
                        new Choice(true, "j >= 1 && j <= n                                                                   (1B)"),
                        new Choice(true, "j > 1                                                                              (1C)"),
                        new Choice(false, "o >= n                                                                             (1D)"),
                        new Choice(false, "j >= 1 && j <= 90                                                                  (1E)")
                ),

                new Question(
                        "Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?",

                        new Choice(false, "{f > -80} while (f > -80) f--; {f > -80}                                           (2A)"),
                        new Choice(true, "{o < 3} while (++o <= 3) f--; {o > 3}                                              (2B)"),
                        new Choice(false, "{true} f = o < i ? o : i; {f >= i}                                                 (2C)"),
                        new Choice(true, "{o <= -80} while (++f < 3) o--; {o < -80}                                          (2D)"),
                        new Choice(false, "{f == 4} f += 1; {f == 3}                                                          (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?",

                        new Choice(true, "Alle Daten von außerhalb des Programms müssen überprüft werden.                    (3A)"),
                        new Choice(true, "Plausibilitätsprüfungen sollen direkt nach der Eingabe erfolgen.                   (3B)"),
                        new Choice(false, "Nicht validierbare Daten reparieren wir direkt nach der Eingabe.                   (3C)"),
                        new Choice(true, "Die Korrektheit kann nicht geprüft werden, nur die Plausibilität.                  (3D)"),
                        new Choice(false, "Zu intensive Prüfung kann z.B. zu einer SQL-Injection führen.                      (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen für Design-by-Contract zu?",

                        new Choice(false, "Objektzustände dürfen geändert werden, wo dies nicht explizit verboten ist.        (4A)"),
                        new Choice(true, "Eine Nachbedingung darf im Untertyp stärker sein als im Obertyp.                   (4B)"),
                        new Choice(false, "Es gilt nur das, was explizit in Zusicherungen steht.                              (4C)"),
                        new Choice(true, "Eine Invariante darf im Untertyp stärker sein als im Obertyp.                      (4D)"),
                        new Choice(false, "Vorbedingungen beschreiben häufig Eigenschaften von Rückgabewerten.                (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen in Bezug auf Algorithmen und Datenstrukturen zu?",

                        new Choice(false, "Quicksort wird auf Arrays häufiger eingesetzt als Mergesort.                       (5A)"),
                        new Choice(false, "Ein AVL-Baum ist stets effizienter als ein einfacher Suchbaum.                     (5B)"),
                        new Choice(false, "Bei unbekannter Datenverteilung gehen wir von Zufallsverteilung aus.               (5C)"),
                        new Choice(false, "Hash-Tabellen sind für geordnete Daten ungeeignet.                                 (5D)"),
                        new Choice(false, "Hash-Tabellen werden wegen ihrer Zufallsabhängigkeit kaum verwendet.               (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. int n=90, o=1, j=1; while (j < n) o *= ++j; \n" +
            "    Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?\n" +
            "    \n" +
            "    XXXXXXXXX n == 90                                                                            (1A)\n" +
            "    XXXXXXXXX j >= 1 && j <= n                                                                   (1B)\n" +
            "    XXXXXXXXX j > 1                                                                              (1C)\n" +
            "    XXXXXXXXX o >= n                                                                             (1D)\n" +
            "    XXXXXXXXX j >= 1 && j <= 90                                                                  (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?\n" +
            "    \n" +
            "    XXXXXXXXX {f > -80} while (f > -80) f--; {f > -80}                                           (2A)\n" +
            "    XXXXXXXXX {o < 3} while (++o <= 3) f--; {o > 3}                                              (2B)\n" +
            "    XXXXXXXXX {true} f = o < i ? o : i; {f >= i}                                                 (2C)\n" +
            "    XXXXXXXXX {o <= -80} while (++f < 3) o--; {o < -80}                                          (2D)\n" +
            "    XXXXXXXXX {f == 4} f += 1; {f == 3}                                                          (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?\n" +
            "    \n" +
            "    XXXXXXXXX Alle Daten von außerhalb des Programms müssen überprüft werden.                    (3A)\n" +
            "    XXXXXXXXX Plausibilitätsprüfungen sollen direkt nach der Eingabe erfolgen.                   (3B)\n" +
            "    XXXXXXXXX Nicht validierbare Daten reparieren wir direkt nach der Eingabe.                   (3C)\n" +
            "    XXXXXXXXX Die Korrektheit kann nicht geprüft werden, nur die Plausibilität.                  (3D)\n" +
            "    XXXXXXXXX Zu intensive Prüfung kann z.B. zu einer SQL-Injection führen.                      (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen für Design-by-Contract zu?\n" +
            "    \n" +
            "    XXXXXXXXX Objektzustände dürfen geändert werden, wo dies nicht explizit verboten ist.        (4A)\n" +
            "    XXXXXXXXX Eine Nachbedingung darf im Untertyp stärker sein als im Obertyp.                   (4B)\n" +
            "    XXXXXXXXX Es gilt nur das, was explizit in Zusicherungen steht.                              (4C)\n" +
            "    XXXXXXXXX Eine Invariante darf im Untertyp stärker sein als im Obertyp.                      (4D)\n" +
            "    XXXXXXXXX Vorbedingungen beschreiben häufig Eigenschaften von Rückgabewerten.                (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen treffen in Bezug auf Algorithmen und Datenstrukturen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Quicksort wird auf Arrays häufiger eingesetzt als Mergesort.                       (5A)\n" +
            "    XXXXXXXXX Ein AVL-Baum ist stets effizienter als ein einfacher Suchbaum.                     (5B)\n" +
            "    XXXXXXXXX Bei unbekannter Datenverteilung gehen wir von Zufallsverteilung aus.               (5C)\n" +
            "    XXXXXXXXX Hash-Tabellen sind für geordnete Daten ungeeignet.                                 (5D)\n" +
            "    XXXXXXXXX Hash-Tabellen werden wegen ihrer Zufallsabhängigkeit kaum verwendet.               (5E)\n" +
            "\n";

    public static final long UID = 247158407528292L;

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