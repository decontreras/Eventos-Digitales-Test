import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { DialogAdd } from './components/dialogAdd/dialog-add.component';
import { EventService } from './services/event.service';
import { PlatformService } from './services/platform.service';
import { TypeEventService } from './services/typeEvent.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit {
  displayedColumns: string[] = ['id', 'platform.name', 'event.description', 'date', 'quantity', 'amount', 'actions'];
  dataSource = new MatTableDataSource<any>([]);
  platforms: any;
  typeEvents: any;
  totalList: any;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private platformService: PlatformService,
    private typeEventService: TypeEventService,
    private eventService: EventService,
    private dialog: MatDialog
  ) { }

  ngOnInit() {
    this.platformService.getPlatform().subscribe(data => {
      this.platforms = data
    })
    this.typeEventService.getTypeEvent().subscribe(data => {
      this.typeEvents = data
    })
    this.loadData();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  loadData(): void {
    this.eventService.getEvent().subscribe(data => {
      if (data) {
        this.dataSource.data = data
        this.totalList = data;
      }
    })
  }

  filterData(value: any): void {
    if (value) {
      this.dataSource.data = this.totalList.filter((row: any) => row.platform.id == value);
    } else {
      this.dataSource.data = this.totalList;
    }
  }

  openDialog(item = null): void {
    this.dialog.open(DialogAdd, {
      width: '400px',
      data: {
        platforms: this.platforms,
        typeEvents: this.typeEvents,
        loadData: () => this.loadData(),
        item: item
      }
    });
  }

  async delete(id: any): Promise<void> {
    await this.eventService.deleteEvent(
      id
    ).subscribe(
      data => {
        this.loadData();
        console.log('success', data);
      },
      error => console.log('oops', error)
    );
  }
}
