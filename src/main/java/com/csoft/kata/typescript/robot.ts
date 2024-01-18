export class Robot {
    private _name: string;
    private static _names: string[] = [];

    constructor() {
        this._name = this.generateUniqueName();
    }

    public get name(): string {
        return this._name;
    }

    public resetName(): void {
        Robot._names.splice(Robot._names.indexOf(this._name), 1);
        this._name = this.generateUniqueName();
    }

    public static releaseNames(): void {
        this._names = [];
    }

    private generateUniqueName(): string {
        let name = this.generateName();
        while (Robot._names.indexOf(name) !== -1) {
            console.log("Name " + name + " already exists, generating a new one");
            name = this.generateName();
        }
        Robot._names.push(name);
        return name;
    }

    private generateName(): string {
        return this.randomCharacter() + this.randomCharacter() + this.randomNumber() + this.randomNumber() + this.randomNumber();
    }

    private randomCharacter(): string {
        const index = Math.floor(Math.random()*Robot.ALPHABET.length);
        return Robot.ALPHABET.charAt(index);
    }

    private randomNumber() : string {
        return Math.floor(Math.random()*10).toString();
    }

    private static ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
}
