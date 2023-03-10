/*!
FullCalendar Core v6.0.0
Docs & License: https://fullcalendar.io
(c) 2022 Adam Shaw
*/
(function (internal_js) {
    'use strict';

    var locale = {
        code: 'ku',
        week: {
            dow: 6,
            doy: 12, // The week that contains Jan 1st is the first week of the year.
        },
        direction: 'rtl',
        buttonText: {
            prev: 'پێشتر',
            next: 'دواتر',
            today: 'ئەمڕو',
            month: 'مانگ',
            week: 'هەفتە',
            day: 'ڕۆژ',
            list: 'بەرنامە',
        },
        weekText: 'هەفتە',
        allDayText: 'هەموو ڕۆژەکە',
        moreLinkText: 'زیاتر',
        noEventsText: 'هیچ ڕووداوێك نیە',
    };

    internal_js.globalLocales.push(locale);

})(FullCalendar.Internal);
