public class DeductionCalculator {

    public double computeSSS(double monthlyGross) {
        if (monthlyGross < 3250) return 135.00;
        else if (monthlyGross < 3750) return 157.50;
        else if (monthlyGross < 4250) return 180.00;
        else if (monthlyGross < 4750) return 202.50;
        else if (monthlyGross < 5250) return 225.00;
        else if (monthlyGross < 5750) return 247.50;
        else if (monthlyGross < 6250) return 270.00;
        else if (monthlyGross < 6750) return 292.50;
        else if (monthlyGross < 7250) return 315.00;
        else if (monthlyGross < 7750) return 337.50;
        else if (monthlyGross < 8250) return 360.00;
        else if (monthlyGross < 8750) return 382.50;
        else if (monthlyGross < 9250) return 405.00;
        else if (monthlyGross < 9750) return 427.50;
        else if (monthlyGross < 10250) return 450.00;
        else if (monthlyGross < 10750) return 472.50;
        else if (monthlyGross < 11250) return 495.00;
        else if (monthlyGross < 11750) return 517.50;
        else if (monthlyGross < 12250) return 540.00;
        else if (monthlyGross < 12750) return 562.50;
        else if (monthlyGross < 13250) return 585.00;
        else if (monthlyGross < 13750) return 607.50;
        else if (monthlyGross < 14250) return 630.00;
        else if (monthlyGross < 14750) return 652.50;
        else if (monthlyGross < 15250) return 675.00;
        else if (monthlyGross < 15750) return 697.50;
        else if (monthlyGross < 16250) return 720.00;
        else if (monthlyGross < 16750) return 742.50;
        else if (monthlyGross < 17250) return 765.00;
        else if (monthlyGross < 17750) return 787.50;
        else if (monthlyGross < 18250) return 810.00;
        else if (monthlyGross < 18750) return 832.50;
        else if (monthlyGross < 19250) return 855.00;
        else if (monthlyGross < 19750) return 877.50;
        else if (monthlyGross < 20250) return 900.00;
        else if (monthlyGross < 20750) return 922.50;
        else if (monthlyGross < 21250) return 945.00;
        else if (monthlyGross < 21750) return 967.50;
        else if (monthlyGross < 22250) return 990.00;
        else if (monthlyGross < 22750) return 1012.50;
        else if (monthlyGross < 23250) return 1035.00;
        else if (monthlyGross < 23750) return 1057.50;
        else if (monthlyGross < 24250) return 1080.00;
        else if (monthlyGross < 24750) return 1102.50;
        else return 1125.00;
    }

    public double computePhilHealth(double monthlyGross) {
        double premium = monthlyGross * 0.03;

        if (premium < 300.0) {
            premium = 300.0;
        }

        if (premium > 1800.0) {
            premium = 1800.0;
        }

        return premium * 0.50;
    }

    public double computePagibig(double monthlyGross) {
        double rate;

        if (monthlyGross < 1000.0) {
            rate = 0.0;
        } else if (monthlyGross <= 1500.0) {
            rate = 0.01;
        } else {
            rate = 0.02;
        }

        double contribution = monthlyGross * rate;

        if (contribution > 100.0) {
            contribution = 100.0;
        }

        return contribution;
    }

    public double computeTax(double taxableIncome) {
        if (taxableIncome <= 20832.0) return 0.0;
        else if (taxableIncome < 33333.0) return (taxableIncome - 20833.0) * 0.20;
        else if (taxableIncome < 66667.0) return 2500.0 + (taxableIncome - 33333.0) * 0.25;
        else if (taxableIncome < 166667.0) return 10833.0 + (taxableIncome - 66667.0) * 0.30;
        else if (taxableIncome < 666667.0) return 40833.33 + (taxableIncome - 166667.0) * 0.32;
        else return 200833.33 + (taxableIncome - 666667.0) * 0.35;
    }
}