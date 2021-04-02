class Play{
    public static void main(String args[]){
        Processor process = new Processor("textToRead/test.txt");
        WordStorage store = process.createStorage();
        Haiku haiku = new Haiku(store);
        System.out.println(haiku.getHaiku());
    }
}