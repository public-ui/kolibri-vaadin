import { bootstrap } from '@public-ui/components';
import { defineCustomElements } from '@public-ui/components/dist/loader';
import { DEFAULT } from '@public-ui/themes';
import '@public-ui/components/assets/codicons/codicon.css';

void (async () => {
	try {
		await bootstrap(
			DEFAULT,
			() => {
				defineCustomElements(window);
			},
			{
				theme: {
					detect: 'auto',
				},
				translation: {
					name: 'de',
				},
			},
		);
	} catch (error) {
		console.warn('Theme registration failed:', error);
	}
})();
