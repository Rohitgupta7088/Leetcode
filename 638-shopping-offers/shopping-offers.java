class Solution {
    int amount = Integer.MAX_VALUE;

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        HashMap<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < price.size(); i++) {
            temp.put((char)('A' + i), 0);
        }

        helper(price, special, needs, 0, temp, 0);
        return amount;
    }

    public void helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int idx, HashMap<Character, Integer> temp, int currCost) {

        if (idx >= special.size()) {

            int totalCost = currCost;
            for (int i = 0; i < needs.size(); i++) {
                totalCost += needs.get(i) * price.get(i);
            }

            amount = Math.min(amount, totalCost);
            return;
        }

        helper(price, special, needs, idx + 1, temp, currCost);

        boolean valid = true;
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < special.get(idx).get(i)) {
                valid = false;
                break;
            }
        }

        if (!valid) {
            return;
        }

        for (int i = 0; i < needs.size(); i++) {
            needs.set(i, needs.get(i) - special.get(idx).get(i));

            temp.put(
                (char)('A' + i),
                temp.get((char)('A' + i)) + special.get(idx).get(i)
            );
        }

        int offerPrice = special.get(idx).get(special.get(idx).size() - 1);
        helper(price, special, needs, idx, temp, currCost+offerPrice);
        
        for (int i = 0; i < needs.size(); i++) {
            needs.set(i, needs.get(i) + special.get(idx).get(i));

            temp.put( (char)('A' + i), temp.get((char)('A' + i)) - special.get(idx).get(i) );
        }
    }
}