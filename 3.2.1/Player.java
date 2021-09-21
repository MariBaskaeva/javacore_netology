import weapon.*;

class Player {
    private Weapon[] weaponSlots;
    
    public Player() {
        weaponSlots = new Weapon[] {
            new Gun(),
            new MachineGun(),
            new Revolver(),
            new RPG(),
            new ShotGun(),
            new SlingShot(),
            new SniperRiffle(),
            new WaterGun()
        };
    }
    
    public int getSlotsCount() {
        return weaponSlots.length;
    }
    
    public void shotWithWeapon(int slot) {
        if ((slot < 0) || (slot > weaponSlots.length - 1)){
            System.out.println("No such slot");
            return;
        }
        Weapon weapon = weaponSlots[slot];
        weapon.shot();
    }
}
