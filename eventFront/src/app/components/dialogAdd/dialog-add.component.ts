import { Component, Inject } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-dialog-add',
  templateUrl: 'dialog-add.component.html',
  styleUrls: ['./dialog-add.component.scss']
})
export class DialogAdd {
  constructor(
    private eventService: EventService,
    public dialogRef: MatDialogRef<DialogAdd>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) { }

  platformF = new FormControl(this.data.item ? this.data.item.platform.id.toString() : '', [Validators.required]);
  amountF = new FormControl(this.data.item ? this.data.item.quantity : '', [Validators.required]);
  dateF = new FormControl(this.data.item ? new Date(this.data.item.date) : '', [Validators.required]);
  typeF = new FormControl(this.data.item ? this.data.item.event.idevent : '', [Validators.required]);

  onNoClick(): void {
    this.dialogRef.close();
  }

  action(): void {
    if (this.data.item == null) {
      this.save();
    } else {
      this.update();
    }
  }

  async save(): Promise<void> {
    if (this.platformF.valid && this.amountF.valid && this.dateF.valid && this.typeF.valid) {
      const unitValue = this.data.typeEvents.find((t: any) => t.idevent === this.typeF.value)?.value;
      await this.eventService.postEvent({
        event_id: this.typeF.value,
        platform_id: this.platformF.value,
        quantity: this.amountF.value,
        amount: this.amountF.value as any * unitValue,
        date: this.dateF.value
      }).subscribe(
        data => {
          this.data.loadData();
          console.log('success', data);
          this.dialogRef.close();
        },
        error => console.log('oops', error)
      );
    }
  }

  async update(): Promise<void> {
    if (this.platformF.valid && this.amountF.valid && this.dateF.valid && this.typeF.valid) {
      const unitValue = this.data.typeEvents.find((t: any) => t.idevent === this.typeF.value)?.value;
      await this.eventService.putEvent({
        event_id: this.typeF.value,
        platform_id: this.platformF.value,
        quantity: this.amountF.value,
        amount: this.amountF.value as any * unitValue,
        date: this.dateF.value
      }, this.data.item.id).subscribe(
        data => {
          this.data.loadData();
          console.log('success', data)
          this.dialogRef.close();
        },
        error => console.log('oops', error)
      );
    }
  }
}