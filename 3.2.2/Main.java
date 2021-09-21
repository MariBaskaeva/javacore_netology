class Main{
	public static void main(String[] args) {
    	TaxService taxService = new TaxService();
    	Bill[] payments = new Bill[] {
    	    new Bill(100000, new IncomeTaxType(), new TaxService()),
            new Bill(230000, new ProgressiveTaxType(), new TaxService()),
            new Bill(123000, new VATaxType(), new TaxService())
    	};
    	for (int i = 0; i < payments.length; ++i) {
        	Bill bill = payments[i];
        	bill.payTaxes();
    	}
	}
}