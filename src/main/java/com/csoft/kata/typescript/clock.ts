export class Clock {

    private hour: number;
    private minute: number;
    private time: Time;

    constructor(hour: number, minute?: number) {
        this.hour = hour;
        this.minute = minute || 0;
        this.time = this.toValidTime(hour, minute);
    }

    public toString(): unknown {
        const hours = this.time.hour.toString().padStart(2, "0");
        const minutes = this.time.minute.toString().padStart(2, "0");
        return `${hours}:${minutes}`;
    }

    public plus(minutes: number): Clock {
        this.minute += (minutes || 0);
        this.time = this.toValidTime(this.hour, this.minute);
        return this;
    }

    public minus(minutes: number): Clock {
        this.minute -= (minutes || 0);
        this.time = this.toValidTime(this.hour, this.minute);
        return this;
    }

    public equals(other: Clock): boolean {
        return this.time.minute == other.time.minute && this.time.hour == other.time.hour;
    }

    private minutesToHour(): void {
        throw new Error('Remove this statement and implement this function')
    }

    private toValidTime(hour: number, minute?: number): Time {
        const minutes = hour * 60 + (minute || 0);
        let hours = Math.floor(minutes / 60) % 24;
        let minutesLeft = minutes % 60;

        if (hours < 0) {
            hours += 24;
        }

        if (minutesLeft < 0) {
            minutesLeft += 60;
        }

        return { hour: hours, minute: minutesLeft };
    }
}

export type Time = {
    hour: number;
    minute: number;
}

// NB
// padStart(length, padString) => string
// const value = "abc"; ${'value'} => abc
