package uz.kozimjon.calctask;


// Java code
public class Calc {
    public static Double calc(String time) {
        if (time.charAt(0) == 43 || time.charAt(0) == 45)
        {
            time += " ";
        }
        else
        {
            time = " " + time + " ";
        }

        // Ko'paytirish va bo'lish uchun

        for (int i = 0; i < time.length(); i++)
        {
            if (time.charAt(i) == 42 || time.charAt(i) == 47)
            {
                int k1 = i - 1;
                int k2 = i + 1;

                String time1 = "";
                String time2 = "";
                String time3 = "";

                String s = "";
                while (time.charAt(k1) >= 48 && time.charAt(k1) <= 57 || time.charAt(k1) == 46)
                {
                    s += time.charAt(k1);
                    k1--;
                }

                for (int j = s.length() - 1; j >= 0; j--)
                {
                    time1 += s.charAt(j);
                }

                while (time.charAt(k2) >= 48 && time.charAt(k2) <= 57 || time.charAt(k1) == 46)
                {
                    time2 += time.charAt(k2);
                    k2++;
                }

                double son1 = Double.parseDouble(time1);
                double son2 = Double.parseDouble(time2);
                double son3;

                if (time.charAt(i) == 42)
                {
                    son3 = son1 * son2;

                    Double x = new Double(son3);
                    time3 = x.toString();
                }

                if (time.charAt(i) == 47)
                {
                    son3 = son1 / son2;

                    Double x = new Double(son3);
                    time3 = x.toString();
                }

                String time4 = "";

                for (int j = 0; j <= k1; j++)
                {
                    time4 += time.charAt(j);
                }

                time4 += time3;

                for (int j = k2; j < time.length(); j++)
                {
                    time4 += time.charAt(j);
                }

                time = time4;
                i = 0;
            }
        }

        if (time.charAt(0) == 32)
        {
            String s = "+";
            for (int i = 1; i < time.length(); i++)
            {
                s += time.charAt(i);
            }

            time = s;
        }

        // Qo'shish va ayirish uchun

        int plussoni = 0;
        int minussoni = 0;

        for (int i = 0; i < time.length(); i++)
        {
            if (time.charAt(i) == 43)
            {
                plussoni++;
            }

            if (time.charAt(i) == 45)
            {
                minussoni++;
            }
        }

        String plus[] = new String [plussoni];
        String minus[] = new String [minussoni];

        int plusindeks = 0;
        int minusindeks = 0;
        for (int i = 0; i < time.length(); i++)
        {
            if (time.charAt(i) == 43)
            {
                int k = i + 1;
                plus[plusindeks] = "";
                while (time.charAt(k) != 43 && time.charAt(k) != 45 && time.charAt(k) != 32)
                {
                    plus[plusindeks] += time.charAt(k);
                    k++;
                }

                plusindeks++;
            }

            if (time.charAt(i) == 45)
            {
                int k = i + 1;
                minus[minusindeks] = "";
                while (time.charAt(k) != 43 && time.charAt(k) != 45 && time.charAt(k) != 32)
                {
                    minus[minusindeks] += time.charAt(k++);
                }

                minusindeks++;
            }
        }

        double newplus[] = new double [plussoni];
        double newminus[] = new double [minussoni];

        double yigindiplus = 0;
        for (int i = 0; i < plussoni; i++)
        {
            newplus[i] = Double.parseDouble(plus[i]);
            yigindiplus += newplus[i];
        }

        double yigindiminus = 0;
        for (int i = 0; i < minussoni; i++)
        {
            newminus[i] = Double.parseDouble(minus[i]);
            yigindiminus += newminus[i];
        }

        double natija = yigindiplus - yigindiminus;

        return natija;
    }
}
